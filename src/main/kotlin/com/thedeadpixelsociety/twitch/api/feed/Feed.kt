package com.thedeadpixelsociety.twitch.api.feed

import com.thedeadpixelsociety.twitch.api.EmptyEndpoint
import retrofit2.Retrofit

/**
 * Implements the Feed endpoint service. See https://dev.twitch.tv/docs/v5/reference/channel-feed/
 */
class Feed : EmptyEndpoint() {
    private var service: FeedService? = null

    override fun init(retrofit: Retrofit) {
        service = retrofit.create(FeedService::class.java)
    }

    /**
     * Gets posts from a specified channel feed.
     * @param channelId The channel ID.
     * @param limit Maximum number of most-recent objects to return. Default: 10. Maximum: 100.
     * @param cursor Tells the server where to start fetching the next set of results in a multi-page response.
     * @param comments Specifies the number of most-recent comments on posts that are included in the response.
     * Default: 5. Maximum: 5.
     * @return A [PostsResponse] if successful; otherwise, null.
     */
    fun posts(channelId: Long, limit: Long = 10, cursor: String? = null, comments: Long = 5): PostsResponse? {
        return attempt(service?.posts(channelId, limit, cursor, comments)?.execute())
    }

    /**
     * Gets a specified post from a specified channel feed.
     * @param channelId The channel ID.
     * @param postId The post ID.
     * @param comments Specifies the number of most-recent comments on posts that are included in the response.
     * Default: 5. Maximum: 5.
     * @return A [Post] if successful; otherwise, null.
     */
    fun post(channelId: Long, postId: String, comments: Long = 5): Post? {
        return attempt(service?.post(channelId, postId, comments)?.execute())
    }

    /**
     * Creates a post in a specified channel feed.
     * @param channelId The channel ID.
     * @param content The post content.
     * @param share When set to true, the post is shared on the channel’s Twitter feed (if connected), with a link to
     * the post’s URL.
     * @return A [CreatePostResponse] if successful; otherwise, null.
     */
    fun createPost(channelId: Long, content: String, share: Boolean = false): CreatePostResponse? {
        return attempt(service?.createPost(channelId, BodyContent(content), share)?.execute())
    }

    /**
     * Deletes a specified post in a specified channel feed.
     * @param channelId The channel ID.
     * @param postId The post ID.
     * @return A [Post] if successful; otherwise, null.
     */
    fun deletePost(channelId: Long, postId: String): Post? {
        return attempt(service?.deletePost(channelId, postId)?.execute())
    }

    /**
     * Creates a reaction to a specified post in a specified channel feed. The reaction is specified by an emote value,
     * which is either an ID (for example, “25” is Kappa) or the string “endorse” (which corresponds to a default face
     * emote).
     * @param channelId The channel ID.
     * @param postId The post ID.
     * @param emoteId The emote ID.
     * @return A [CreateReactionResponse] if successful; otherwise, null.
     */
    fun createReaction(channelId: Long, postId: String, emoteId: String = "endorse"): CreateReactionResponse? {
        return attempt(service?.createReaction(channelId, postId, emoteId)?.execute())
    }

    /**
     * Deletes a specified reaction to a specified post in a specified channel feed. The reaction is specified by an
     * emote ID (for example, “25” is Kappa) or the string “endorse” (which corresponds to a default face emote).
     * @param channelId The channel ID.
     * @param postId The post ID.
     * @param emoteId The emote ID.
     * @return A [DeleteReactionResponse] if successful; otherwise, null.
     */
    fun deleteReaction(channelId: Long, postId: String, emoteId: String = "endorse"): DeleteReactionResponse? {
        return attempt(service?.deleteReaction(channelId, postId, emoteId)?.execute())
    }

    /**
     * Gets all comments on a specified post in a specified channel feed.
     * @param channelId The channel ID.
     * @param postId The post ID.
     * @param limit Maximum number of most-recent objects to return. Default: 10. Maximum: 100.
     * @param cursor Tells the server where to start fetching the next set of results in a multi-page response.
     * @return A [CommentsResponse] is successful; otherwise, null.
     */
    fun comments(channelId: Long, postId: String, limit: Long = 10, cursor: String? = null): CommentsResponse? {
        return attempt(service?.comments(channelId, postId, limit, cursor)?.execute())
    }

    /**
     * Creates a comment to a specified post in a specified channel feed.
     * @param channelId The channel ID.
     * @param postId The post ID.
     * @param content The comment content.
     * @return A [Comment] if successful; otherwise, null.
     */
    fun createComment(channelId: Long, postId: String, content: String): Comment? {
        return attempt(service?.createComment(channelId, postId, BodyContent(content))?.execute())
    }

    /**
     * Deletes a specified comment on a specified post in a specified channel feed.
     * @param channelId The channel ID.
     * @param postId The post ID.
     * @param commentId The comment ID.
     * @return A [Comment] if successful; otherwise, null.
     */
    fun deleteComment(channelId: Long, postId: String, commentId: String): Comment? {
        return attempt(service?.deleteComment(channelId, postId, commentId)?.execute())
    }


    /**
     * Creates a reaction to a specified comment on a specified post in a specified channel feed. The reaction is
     * specified by an emote value, which is either an ID (for example, “25” is Kappa) or the string “endorse”
     * (which corresponds to a default face emote).
     * @param channelId The channel ID.
     * @param postId The post ID.
     * @param commentId The comment ID.
     * @param emoteId The emote ID.
     * @return A [CreateReactionResponse] if successful; otherwise, null.
     */
    fun createCommentReaction(channelId: Long, postId: String, commentId: String, emoteId: String = "endorse"): CreateReactionResponse? {
        return attempt(service?.createCommentReaction(channelId, postId, commentId, emoteId)?.execute())
    }

    /**
     * Deletes a reaction to a specified comment on a specified post in a specified channel feed. The reaction is
     * specified by an emote value, which is either an ID (for example, “25” is Kappa) or the string “endorse”
     * (which corresponds to a default face emote).
     * @param channelId The channel ID.
     * @param postId The post ID.
     * @param commentId The comment ID.
     * @param emoteId The emote ID.
     * @return A [DeleteReactionResponse] if successful; otherwise, null.
     */
    fun deleteCommentReaction(channelId: Long, postId: String, commentId: String, emoteId: String = "endorse"): DeleteReactionResponse? {
        return attempt(service?.deleteCommentReaction(channelId, postId, commentId, emoteId)?.execute())
    }
}