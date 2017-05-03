package com.thedeadpixelsociety.twitch.api.feed

import retrofit2.Call
import retrofit2.http.*

interface FeedService {
    @GET("feed/{channel_id}/posts")
    fun posts(
        @Path("channel_id") channelId: Long,
        @Query("limit") limit: Long,
        @Query("cursor") cursor: String? = null,
        @Query("comments") comments: Long
    ): Call<PostsResponse>

    @GET("feed/{channel_id}/posts/{post_id}")
    fun post(
        @Path("channel_id") channelId: Long,
        @Path("post_id") postId: String,
        @Query("comments") comments: Long
    ): Call<Post>

    @POST("feed/{channel_id}/posts")
    fun createPost(
        @Path("channel_id") channelId: Long,
        @Body content: BodyContent,
        @Query("share") share: Boolean
    ): Call<CreatePostResponse>

    @DELETE("feed/{channel_id}/posts/{post_id}")
    fun deletePost(@Path("channel_id") channelId: Long, @Path("post_id") postId: String): Call<Post>

    @POST("feed/{channel_id}/posts/{post_id}/reactions")
    fun createReaction(
        @Path("channel_id") channelId: Long,
        @Path("post_id") postId: String,
        @Query("emote_id") emoteId: String
    ): Call<CreateReactionResponse>

    @DELETE("feed/{channel_id}/posts/{post_id}/reactions")
    fun deleteReaction(
        @Path("channel_id") channelId: Long,
        @Path("post_id") postId: String,
        @Query("emote_id") emoteId: String
    ): Call<DeleteReactionResponse>

    @GET("feed/{channel_id}/posts/{post_id}/comments")
    fun comments(
        @Path("channel_id") channelId: Long,
        @Path("post_id") postId: String,
        @Query("limit") limit: Long,
        @Query("cursor") cursor: String? = null
    ): Call<CommentsResponse>

    @POST("feed/{channel_id}/posts/{post_id}/comments")
    fun createComment(
        @Path("channel_id") channelId: Long,
        @Path("post_id") postId: String,
        @Body content: BodyContent
    ): Call<Comment>

    @DELETE("feed/{channel_id}/posts/{post_id}/comments/{comment_id}")
    fun deleteComment(
        @Path("channel_id") channelId: Long,
        @Path("post_id") postId: String,
        @Path("comment_id") commentId: String
    ): Call<Comment>

    @POST("feed/{channel_id}/posts/{post_id}/comments/{comment_id}/reactions")
    fun createCommentReaction(
        @Path("channel_id") channelId: Long,
        @Path("post_id") postId: String,
        @Path("comment_id") commentId: String,
        @Query("emote_id") emoteId: String
    ): Call<CreateReactionResponse>

    @DELETE("feed/{channel_id}/posts/{post_id}/comments/{comment_id}/reactions")
    fun deleteCommentReaction(
        @Path("channel_id") channelId: Long,
        @Path("post_id") postId: String,
        @Path("comment_id") commentId: String,
        @Query("emote_id") emoteId: String
    ): Call<DeleteReactionResponse>
}