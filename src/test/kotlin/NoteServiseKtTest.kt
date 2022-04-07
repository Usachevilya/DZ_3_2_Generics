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
        commentId = 1,
        noteId = 3,
        replyTo = 1,
        message = "add commentEdit"
    )
    var comments4 = Comments(
        commentId = 5,
        noteId = 3,
        replyTo = 1,
        message = "add comment4"
    )
    var comments5 = Comments(
        commentId = 5,
        noteId = 3,
        replyTo = 1,
        message = "add comment5"
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
        noteId = 3,
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
        comments = emptyList()
    )
    var note4 = Notes(
        noteId = 3,
        title = "Заголовок1",
        text = "Текст заметки11",
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
        assertEquals(1, result)
    }

    @Test
    fun createCommentsTest() {
        notesAdd(note1)
        createComments(comments1)
        val result = notes.last().comments.last().commentId
        assertEquals(1, result)
    }

    @Test
    fun deleteTest() {
        var result = true
        notesAdd(note1)
        notesAdd(note2)
        notesAdd(note3)
        val size = notes.size
        delete(2)
        if (size > notes.size) {
            result = false
        }
        assertTrue(result)
    }

    @Test
    fun deleteCommentTest() {
        notesAdd(note1)
        createComments(comments1)
        createComments(comments2)
        createComments(comments3)
        deleteComment(comments2)
        val result = comentDelete.last().commentId
        assertEquals(comments2.commentId, result)
    }

    @Test
    fun editTest() {
        notesAdd(note1)
        notesAdd(note3)
        edit(noteEdit)
        val result = notes[0].text
        assertEquals("Текст заметки1", result)
    }

    @Test
    fun editCommentTest() {
        notesAdd(note1)
        notesAdd(note2)
        createComments(comments1)
        createComments(comments2)
        editComment(commentsEdit)
        val result = notes[0].comments[0].message
        assertEquals(commentsEdit.message, result)
    }

    @Test
    fun getTest() {
        notesAdd(note1)
        notesAdd(note2)
        notesAdd(note3)
        val result = get().last().noteId
        assertEquals(3, result)
    }

    @Test
    fun getByIdTEst() {
        notesAdd(note2)
        notesAdd(note3)
        notesAdd(note4)
        val result = getById(3).size
        assertEquals(4, result)
    }

    @Test
    fun getCommentsTest() {
        notesAdd(note1)
        notesAdd(note3)
        createComments(comments1)
        createComments(comments2)
        createComments(comments4)
        createComments(comments5)
        val result = getComments(3).size
        assertEquals(2, result)
    }

    @Test
    fun getFriendsNotesTest() {
        notesAdd(note1)
        notesAdd(note2)
        notesAdd(note3)
        val result = getFriendsNotes("Frends").size
        assertEquals(21, result)
    }

    @Test
    fun restoreComment() {
        notesAdd(note1)
        notesAdd(note2)
        notesAdd(note3)
        createComments(comments1)
        createComments(comments2)
        createComments(comments3)
        deleteComment(comments2)
        restoreComment(2)
        val result = notes[0].comments.last().commentId
        assertEquals(2, result)
    }
}

