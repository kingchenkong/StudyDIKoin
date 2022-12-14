package com.kck.studydikoin.core.domain

import com.google.gson.annotations.SerializedName

data class GitHubUser(
    val avatar_url: String,
    val bio: Any,
    val blog: String,
    val company: Any,
    val created_at: String,
    val email: Any,
    val events_url: String,
    val followers: Int,
    val followers_url: String,
    val following: Int,
    val following_url: String,
    val gists_url: String,
    val gravatar_id: String,
    val hireable: Any,
    val html_url: String,
    val id: Int,
    val location: String,
    val login: String,
    val name: String,
    val node_id: String,
    val organizations_url: String,
    val public_gists: Int,
    val public_repos: Int,
    val received_events_url: String,
    val repos_url: String,
    val site_admin: Boolean,
    val starred_url: String,
    val subscriptions_url: String,
    val twitter_username: Any,
    val type: String,
    val updated_at: String,
    val url: String
) {
    companion object {
        fun toEmpty(): GitHubUser {
            return GitHubUser(
                "", "", "", "", "", "", "", 0,
                "", 0, "", "", "", "", "",
                0, "", "", "", "", "", 0, 0,
                "", "", false, "", "", "",
                "", "", "",
            )
        }
    }
}


//data class GitHubUser(
//    @SerializedName("avatar_url")
//    val avatarUrl: String,
//    @SerializedName("bio")
//    val bio: Any,
//    @SerializedName("blog")
//    val blog: String,
//    @SerializedName("company")
//    val company: Any,
//    @SerializedName("created_at")
//    val createdAt: String,
//    @SerializedName("email")
//    val email: Any,
//    @SerializedName("events_url")
//    val eventsUrl: String,
//    @SerializedName("followers")
//    val followers: Int,
//    @SerializedName("followers_url")
//    val followersUrl: String,
//    @SerializedName("following")
//    val following: Int,
//    @SerializedName("following_url")
//    val followingUrl: String,
//    @SerializedName("gists_url")
//    val gistsUrl: String,
//    @SerializedName("gravatar_id")
//    val gravatarId: String,
//    @SerializedName("hireable")
//    val hireable: Any,
//    @SerializedName("html_url")
//    val htmlUrl: String,
//    @SerializedName("id")
//    val id: Int,
//    @SerializedName("location")
//    val location: String,
//    @SerializedName("login")
//    val login: String,
//    @SerializedName("name")
//    val name: String,
//    @SerializedName("node_id")
//    val nodeId: String,
//    @SerializedName("organizations_url")
//    val organizationsUrl: String,
//    @SerializedName("public_gists")
//    val publicGists: Int,
//    @SerializedName("public_repos")
//    val publicRepos: Int,
//    @SerializedName("received_events_url")
//    val receivedEventsUrl: String,
//    @SerializedName("repos_url")
//    val reposUrl: String,
//    @SerializedName("site_admin")
//    val siteAdmin: Boolean,
//    @SerializedName("starred_url")
//    val starredUrl: String,
//    @SerializedName("subscriptions_url")
//    val subscriptionsUrl: String,
//    @SerializedName("twitter_username")
//    val twitterUsername: Any,
//    @SerializedName("type")
//    val type: String,
//    @SerializedName("updated_at")
//    val updatedAt: String,
//    @SerializedName("url")
//    val url: String
//)