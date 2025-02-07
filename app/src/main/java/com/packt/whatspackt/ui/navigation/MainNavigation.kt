package com.packt.whatspackt.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.packt.framework.navigation.NavRoutes
import com.packt.chat.ui.ChatScreen
import com.packt.conversations.ui.ui.ConversationsListScreen
import com.packt.create_chat.ui.CreateConversationScreen

@Composable
fun MainNavigation(
    navHostController: NavHostController
) {

    NavHost(navController = navHostController, startDestination = NavRoutes.CONVERSATIONS_LIST) {
        //Add composables destinations here
        with(navHostController) {
            addConversationsList(this)
            addNewConversation(this)
            addChat(this)
        }
    }
}

private fun NavGraphBuilder.addConversationsList(
    navHostController: NavHostController
) {
    composable(NavRoutes.CONVERSATIONS_LIST) {
        ConversationsListScreen(
            onNewConversationClick = {
                navHostController.navigate(NavRoutes.NEW_CONVERSATION)
            },
            onConversationClick = { chatId ->
                navHostController.navigate(NavRoutes.CHAT.replace("{chatId}", chatId))
            }
        )
    }
}

private fun NavGraphBuilder.addNewConversation(
    navHostController: NavHostController
) {
    composable(NavRoutes.NEW_CONVERSATION) {
        CreateConversationScreen(
            onCreateConversation = {
                navHostController.navigate(NavRoutes.CHAT)
            }
        )
    }
}

private fun NavGraphBuilder.addChat(
    navHostController: NavHostController
) {
    composable(
        route = NavRoutes.CHAT,
        arguments = listOf(
            navArgument(NavRoutes.ChatArgs.CHAT_ID) { type = NavType.StringType }
        )
    ) { navBackStackEntry ->
        val chatId = navBackStackEntry.arguments?.getString(NavRoutes.ChatArgs.CHAT_ID)
        ChatScreen(
            chatId = chatId,
            onBack = {
                navHostController.popBackStack()
            }
        )
    }
}