data class Comments(
    val commentId: Int,
    val noteId: Int,
    val replyTo: Int,
    var message: String,
)