package com.example.ludanto.data.storage

import com.example.ludanto.domain.entity.Session
import io.paperdb.Paper
import javax.inject.Inject

class SessionStorage @Inject constructor() {
    private val book = Paper.book()

    fun saveSession(session: Session) { Paper.book(SESSION_BOOK_NAME).write(ARG_SESSION, session) }

    fun getSession() : Session = Paper.book(SESSION_BOOK_NAME).read(ARG_SESSION)

    fun isSessionExists() : Boolean = Paper.book(SESSION_BOOK_NAME).contains(ARG_SESSION)

    fun clearSession() { Paper.book(SESSION_BOOK_NAME).delete(ARG_SESSION) }

    companion object {
        const val SESSION_BOOK_NAME = "Session"
        const val ARG_SESSION = "session"
    }
}