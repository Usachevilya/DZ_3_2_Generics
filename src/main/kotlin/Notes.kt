data class Notes(
    var noteId: Int,
    var title: String,
    var text: String,
    var privacy: Int,
    var commentPrivacy: Int,
    var privacyView: String,
    var privacyComment: String,
    var comments: List<Comments>
)