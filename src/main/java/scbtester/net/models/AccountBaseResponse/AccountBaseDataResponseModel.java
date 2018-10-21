package scbtester.net.models.AccountBaseResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountBaseDataResponseModel {

    @JsonProperty("id")
    private long id;

    @JsonProperty("url")
    private String url;

    @JsonProperty("bio")
    private Object bio;

    @JsonProperty("avatar")
    private String avatar;

    @JsonProperty("avatar_name")
    private String avatar_name;

    @JsonProperty("cover")
    private String cover;

    @JsonProperty("cover_name")
    private String cover_name;

    @JsonProperty("reputation")
    private long reputation;

    @JsonProperty("reputation_name")
    private String reputation_name;

    @JsonProperty("created")
    private long created;

    @JsonProperty("pro_expiration")
    private boolean pro_expiration;

    @JsonProperty("is_blocked")
    private boolean is_blocked;

    @JsonProperty("user_follow")
    private AccountBaseDataUserFollowResponseModel  user_follow;

    @JsonProperty("error")
    private String error;

    @JsonProperty("request")
    private String request;

    @JsonProperty("method")
    private String method;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public AccountBaseDataResponseModel(){};

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getBio() {
        return bio;
    }

    public void setBio(Object bio) {
        this.bio = bio;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar_name() {
        return avatar_name;
    }

    public void setAvatar_name(String avatar_name) {
        this.avatar_name = avatar_name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCover_name() {
        return cover_name;
    }

    public void setCover_name(String cover_name) {
        this.cover_name = cover_name;
    }

    public long getReputation() {
        return reputation;
    }

    public void setReputation(long reputation) {
        this.reputation = reputation;
    }

    public String getReputation_name() {
        return reputation_name;
    }

    public void setReputation_name(String reputation_name) {
        this.reputation_name = reputation_name;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public boolean isPro_expiration() {
        return pro_expiration;
    }

    public void setPro_expiration(boolean pro_expiration) {
        this.pro_expiration = pro_expiration;
    }

    public boolean isIs_blocked() {
        return is_blocked;
    }

    public void setIs_blocked(boolean is_blocked) {
        this.is_blocked = is_blocked;
    }

    public AccountBaseDataUserFollowResponseModel getUser_follow() {
        return user_follow;
    }

    public void setUser_follow(AccountBaseDataUserFollowResponseModel user_follow) {
        this.user_follow = user_follow;
    }
}
