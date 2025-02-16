package com.packt.conversations.ui

import androidx.annotation.StringRes
import com.packt.conversations.R

data class ConversationsListTab(
    @StringRes val title: Int
)

fun generateTabs(): List<ConversationsListTab> {
    return listOf(
        ConversationsListTab(
            title = R.string.conversations_tab_status_title
        ),
        ConversationsListTab(
            title = R.string.conversations_tab_chats_title
        ),
        ConversationsListTab(
            title = R.string.conversations_tab_calls_title
        )
    )
}
