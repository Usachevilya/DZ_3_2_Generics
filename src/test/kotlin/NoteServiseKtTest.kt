import org.junit.Test

import org.junit.Assert.*

class NoteServiseKtTest {

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

    @Test
    fun notesAddTest() {
        notesAdd(note1)
        val result = notes.last().noteId
        assertEquals(1,result)
    }

    @Test
    fun createCommentsTest() {
        notesAdd(note1)
        createComments(comments1)
        val result = notes.last().comments.last().commentId
        assertEquals(1,result)
    }

    @Test
    fun deleteTest() {
        var result = true
        notesAdd(note1)
        notesAdd(note2)
        notesAdd(note3)
        delete(2)
        for (i in notes.indices){
            if (notes[i].noteId == 2) {
                result = false
                break
            }
        }
        assertTrue(result)
    }

    @Test
    fun setComentDelete() {
    }

    @Test
    fun notesAdd() {
    }

    @Test
    fun createComments() {
    }

    @Test
    fun delete() {
    }

    @Test
    fun deleteComment() {
    }

    @Test
    fun edit() {
    }

    @Test
    fun editComment() {
    }

    @Test
    fun get() {
    }

    @Test
    fun getById() {
    }

    @Test
    fun getComments() {
    }

    @Test
    fun getFriendsNotes() {
    }

    @Test
    fun restoreComment() {
    }
}