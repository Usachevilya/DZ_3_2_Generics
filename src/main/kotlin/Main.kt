class Main {}

fun main() {
    var comments2 = Comments(
        commentId = 2,
        noteId = 1,
        replyTo = 1,
        message = "add comment2"
    )
    var comments1 = Comments(
        commentId = 1,
        noteId = 1,
        replyTo = 1,
        message = "add comment"
    )
    var comments3 = Comments(
        commentId = 3,
        noteId = 1,
        replyTo = 1,
        message = "add comment3"
    )
    var commentsEdit = Comments(
        commentId = 3,
        noteId = 3,
        replyTo = 1,
        message = "add commentEdit"
    )
    var note1 = Notes(
        noteId = 1,
        title = "Заголовок1",
        text = "Текст заметки1",
        privacy = 1,
        commentPrivacy = 1,
        privacyView = "Frends",
        privacyComment = "Frends",
        comments = mutableListOf(comments1)
    )

    var note2 = Notes(
        noteId = 2,
        title = "Заголовок1",
        text = "Текст заметки1",
        privacy = 1,
        commentPrivacy = 1,
        privacyView = "Frends",
        privacyComment = "Frends",
        comments = mutableListOf(comments2)
    )
    var note3 = Notes(
        noteId = 3,
        title = "Заголовок1",
        text = "Текст заметки1",
        privacy = 1,
        commentPrivacy = 1,
        privacyView = "Frends",
        privacyComment = "Frends",
        comments = mutableListOf(comments1)
    )
    var noteEdit = Notes(
        noteId = 3,
        title = "Заголовок1",
        text = "Текст заметкиEdit",
        privacy = 1,
        commentPrivacy = 1,
        privacyView = "Frends",
        privacyComment = "Frends",
        comments = mutableListOf(comments1)
    )
    notesAdd(note1)
    println(notes)
    notesAdd(note2)
    println(notes)
    createComments(comments2)
    println(notes)
    createComments(comments3)
    println(notes)
    deleteComment(comments2)
    println(notes)
    restoreComment(2)
    println(notes)
    get()
}

