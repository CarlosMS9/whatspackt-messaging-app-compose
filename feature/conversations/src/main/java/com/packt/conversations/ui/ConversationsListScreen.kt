package com.packt.conversations.ui

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.packt.conversations.R
import com.packt.conversations.model.Conversation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConversationsListScreen(
    onNewConversationClick: () -> Unit,
    onConversationClick: (chatId: String) -> Unit
) {
    val context = LocalContext.current
    val tabs = generateTabs()
    val selectedIndex = remember { mutableIntStateOf(1) }
    val pagerState = rememberPagerState(initialPage = 1) { tabs.size }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.conversations_list_title))
                },
                actions = {
                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(Icons.Rounded.Menu, contentDescription = "Menu" )
                    }
                }
            )
        },
        bottomBar = {
            TabRow(selectedTabIndex = 1) {
                tabs.forEachIndexed { index, _ ->
                    Tab(
                        text = { Text(stringResource(id = tabs[index].title)) },
                        selected = index == 1,
                        onClick = {
                            Toast.makeText(context, "${context.getString(tabs[index].title)} pressed", Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onNewConversationClick) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        },
        content =  { innerPadding ->
            HorizontalPager(
                modifier = Modifier.padding(innerPadding),
                state = pagerState,
            ) { index ->
                when (index) {
                    0 -> {
                        //Status
                    }
                    1 -> {
                        ConversationList(
                            conversations = generateFakeConversations(),
                            onConversationClick = onConversationClick
                        )

                    }
                    2 -> {
                        //Chats

                    }
                }
            }
            LaunchedEffect(selectedIndex.intValue) {
                pagerState.animateScrollToPage(selectedIndex.intValue)
            }
        }
    )
}

fun generateFakeConversations(): List<Conversation> {
    return listOf(
        Conversation(
            id = "1",
            name = "John Doe",
            message = "Hey, how are you?",
            timestamp = "10:30",
            avatar = "https://i.pravatar.cc/150?u=1",
            unreadCount = 2
        ),
        Conversation(
            id = "2",
            name = "Jane Smith",
            message = "Unos besos o que padrino",
            timestamp = "11:15",
            avatar = "https://i.pravatar.cc/150?u=2",
            unreadCount = 5
        )
    )
}