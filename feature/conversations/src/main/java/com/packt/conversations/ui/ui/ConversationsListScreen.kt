package com.packt.conversations.ui.ui

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
import androidx.compose.ui.res.stringResource
import com.packt.conversations.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConversationsListScreen(
    onNewConversationClick: () -> Unit,
    onConversationClick: (chatId: String) -> Unit
) {
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
                        onClick = { /*TODO*/ }
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
                        //ConversationsListScreen(onNewConversationClick = onNewConversationClick)
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