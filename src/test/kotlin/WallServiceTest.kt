import org.junit.Test

import ru.netology.Comment
import ru.netology.Post
import ru.netology.PostNotFoundException
import ru.netology.WallService
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class WallServiceTest {

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        var checkResult = WallService()
        var post = checkResult.addPost(Post(1, "Как дела?"))
        var newComment = checkResult.createComment(5, Comment(1, "Проверка"))
    }

    @Test
    fun withoutException() {
        var service = WallService()
        var newPost = service.addPost(Post(1, "Новый день"))
        var comment1 = service.createComment(1, Comment(1, "Прекрасный новый день"))
        val checkText = "Прекрасный новый день"
        assertEquals(checkText, "Прекрасный новый день")
    }
}

