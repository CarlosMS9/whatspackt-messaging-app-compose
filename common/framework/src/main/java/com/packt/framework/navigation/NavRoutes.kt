package com.packt.framework.navigation

object NavRoutes {
    const val CONVERSATIONS_LIST = "conversations_list"
    const val NEW_CONVERSATION = "create_conversation"
    const val CHAT = "chat/{chatId}"

    object ChatArgs {
        const val CHAT_ID = "chatId"
    }
}