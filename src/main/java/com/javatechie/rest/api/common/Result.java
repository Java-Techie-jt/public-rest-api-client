
package com.javatechie.rest.api.common;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "title", "href", "ingredients", "thumbnail" })
public class Result {

	@JsonProperty("title")
	private String title;
	@JsonProperty("href")
	private String href;
	@JsonProperty("ingredients")
	private String ingredients;
	@JsonProperty("thumbnail")
	private String thumbnail;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("href")
	public String getHref() {
		return href;
	}

	@JsonProperty("href")
	public void setHref(String href) {
		this.href = href;
	}

	@JsonProperty("ingredients")
	public String getIngredients() {
		return ingredients;
	}

	@JsonProperty("ingredients")
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	@JsonProperty("thumbnail")
	public String getThumbnail() {
		return thumbnail;
	}

	@JsonProperty("thumbnail")
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		return "Result [title=" + title + ", href=" + href + ", ingredients=" + ingredients + ", thumbnail=" + thumbnail
				+ ", additionalProperties=" + additionalProperties + "]";
	}

}
