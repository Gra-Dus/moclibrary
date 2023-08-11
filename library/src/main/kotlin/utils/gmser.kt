package utils

import android.os.NetworkOnMainThreadException
import java.util.Properties
import javax.mail.MessagingException
import javax.mail.Session
import kotlin.coroutines.suspendCoroutine
import kotlin.coroutines.resume

internal class gmser {
    private val pr = Properties()
    private var ie = ""
    private var pte = ""
    fun sups(ie: String, pte: String) {
        this.ie = ie
        this.pte = pte
    }

    suspend fun sm(t: String, tx: String, e: List<String>): Boolean = suspendCoroutine { continuation ->
        try {
            gs()
            continuation.resume(true)
        } catch (e: MessagingException) {
            continuation.resume(false)
        } catch (e: NetworkOnMainThreadException) {
            continuation.resume(false)
        }
    }

    private fun gs(): Session {
        return Session.getDefaultInstance(pr)
    }
}