package scbtester.net.models.ImageUploadResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageUploadDataResponseModel {

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("datetime")
    private Object datetime;

    @JsonProperty("type")
    private String type;

    @JsonProperty("animated")
    private boolean animated;

    @JsonProperty("width")
    private long width;

    @JsonProperty("height")
    private long height;

    @JsonProperty("size")
    private long size;

    @JsonProperty("views")
    private long views;

    @JsonProperty("bandwidth")
    private long bandwidth;

    @JsonProperty("vote")
    private Object vote;

    @JsonProperty("favorite")
    private boolean favorite;

    @JsonProperty("nsfw")
    private Object nsfw;

    @JsonProperty("section")
    private Object section;

    @JsonProperty("account_url")
    private Object account_url;

    @JsonProperty("account_id")
    private long account_id;

    @JsonProperty("is_ad")
    private boolean is_ad;

    @JsonProperty("in_most_viral")
    private boolean in_most_viral;

    @JsonProperty("has_sound")
    private boolean has_sound;

    @JsonProperty("tags")
    private Object tags;

    @JsonProperty("ad_type")
    private long ad_type;

    @JsonProperty("ad_url")
    private String ad_url;

    @JsonProperty("in_gallery")
    private boolean in_gallery;

    @JsonProperty("deletehash")
    private String deletehash;

    @JsonProperty("name")
    private String name;

    @JsonProperty("link")
    private String link;

    @JsonProperty("error")
    private String error;

    @JsonProperty("request")
    private String request;

    @JsonProperty("method")
    private String method;

    ImageUploadDataResponseModel(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getDatetime() {
        return datetime;
    }

    public void setDatetime(Object datetime) {
        this.datetime = datetime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAnimated() {
        return animated;
    }

    public void setAnimated(boolean animated) {
        this.animated = animated;
    }

    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public long getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(long bandwidth) {
        this.bandwidth = bandwidth;
    }

    public Object getVote() {
        return vote;
    }

    public void setVote(Object vote) {
        this.vote = vote;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public Object getNsfw() {
        return nsfw;
    }

    public void setNsfw(Object nsfw) {
        this.nsfw = nsfw;
    }

    public Object getSection() {
        return section;
    }

    public void setSection(Object section) {
        this.section = section;
    }

    public Object getAccount_url() {
        return account_url;
    }

    public void setAccount_url(Object account_url) {
        this.account_url = account_url;
    }

    public long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(long account_id) {
        this.account_id = account_id;
    }

    public boolean isIs_ad() {
        return is_ad;
    }

    public void setIs_ad(boolean is_ad) {
        this.is_ad = is_ad;
    }

    public boolean isIn_most_viral() {
        return in_most_viral;
    }

    public void setIn_most_viral(boolean in_most_viral) {
        this.in_most_viral = in_most_viral;
    }

    public boolean isHas_sound() {
        return has_sound;
    }

    public void setHas_sound(boolean has_sound) {
        this.has_sound = has_sound;
    }

    public Object getTags() {
        return tags;
    }

    public void setTags(Object tags) {
        this.tags = tags;
    }

    public long getAd_type() {
        return ad_type;
    }

    public void setAd_type(long ad_type) {
        this.ad_type = ad_type;
    }

    public String getAd_url() {
        return ad_url;
    }

    public void setAd_url(String ad_url) {
        this.ad_url = ad_url;
    }

    public boolean isIn_gallery() {
        return in_gallery;
    }

    public void setIn_gallery(boolean in_gallery) {
        this.in_gallery = in_gallery;
    }

    public String getDeletehash() {
        return deletehash;
    }

    public void setDeletehash(String deletehash) {
        this.deletehash = deletehash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

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
}
