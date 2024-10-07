package ru.netology


data class Post (
    val id : Int?,
    val text: String?,
)

data class Comment (
    val id : Int?,
    val text: String?,
)

class PostNotFoundException (message: String) : RuntimeException (message)

class WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var unicumId = 0

    fun addPost(post: Post): Post {
      posts += post.copy(id = ++unicumId)
     return posts.last()
    }

    fun createComment(postId: Int, comment: Comment): Comment {
        for ((index, post) in posts.withIndex()) {
            if(posts[index].id == postId) {
                comments += comment.copy(text = comment.text)
                return comments.last()
            }
        }
       return throw PostNotFoundException ("Нет похожего $postId")
    }

    fun checkPost() {
        for (post in posts) {
            print(post)
            println()
        }
    }

    fun checkComment() {
        for (comment in comments) {
            print(comment)
            println()
        }
    }
}


fun main() {
  val service = WallService()
    service.addPost(Post(1,"Как дела?"))
    service.addPost(Post(2, "Что нового в мире?"))
    service.createComment(1, Comment(1, "Дела отлично!"))
    service.createComment(1, Comment(2,"Дела просто замечательно!"))
    service.createComment(2,Comment(1, "Не слежу за новостями"))
    service.createComment(5,Comment(1,"Проверка"))
    service.createComment(5,Comment(5,"Еще одна проверка"))
    service.checkPost()
    service.checkComment()
}