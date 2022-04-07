class NoteServise {
}

var notes = mutableListOf<Notes>()
var comentDelete = mutableListOf<Comments>()


fun notesAdd(note: Notes) {
    notes += note
}

fun createComments(comments: Comments) {
    for (i in notes.indices) {
        if (comments.noteId == notes[i].noteId) {
            notes[i].comments += comments
        }
    }
}

fun delete(noteId: Int) {
    for (i in notes.indices) {
        if (notes[i].noteId == noteId) {
            notes.remove(notes[i])
            break
        }
    }
}

fun deleteComment(commentsD: Comments) {
    for (i in notes.indices) {
        for (j in notes[i].comments.indices) {
            if (notes[i].comments[j].commentId == commentsD.commentId) {
                notes[i].comments -= commentsD
                comentDelete += commentsD
                break
            }
        }
    }
}

fun edit(note: Notes) {
    for (i in notes.indices) {
        if (notes[i].noteId == note.noteId) {
            notes[i] = note
            break
        }
    }
}

fun editComment(commentsEdit: Comments) {
    for (i in notes.indices) {
        for (j in notes[i].comments.indices) {
            if (notes[i].comments[j].commentId == commentsEdit.commentId) {
                notes[i].comments[j].message = commentsEdit.message
                break
            }
        }
    }
}

fun get(): List<Notes> {
    var result = emptyList<Notes>()
    for (i in notes.indices) {
        result = listOf(notes[i])
    }
    return result
}

fun getById(id: Int): Notes? {
    for (i in notes.indices) {
        if (notes[i].noteId == id) {
            return notes[i]
        }
    }
    val resultError: Notes? = null
    return resultError
}

fun getComments(noteId: Int): List<Comments>? {
    for (i in notes.indices) {
        if (notes[i].noteId == noteId) {
            return notes[i].comments
        }
    }
    return null
}

fun getFriendsNotes(privacyView: String): Notes? {
    for (i in notes.indices) {
        if (notes[i].privacyView == privacyView) {
            return notes[i]
        }
    }
    return null
}
fun restoreComment(commentId: Int) {
    for (i in comentDelete.indices) {
        if (comentDelete[i].commentId == commentId) {
            createComments(comentDelete.removeAt(i))
            break
        }
    }
}



