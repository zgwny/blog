package com.zwy.blog.nosql.elasticsearch.document;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 搜索中的博客信息
 */
@Document(indexName = "pms", type = "blog",shards = 1,replicas = 0)
public class EsBlog implements Serializable {
    private static final long serialVersionUID = -1L;
    @Id
    private Integer id; 
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String title;
    private String image;
    private Integer goods;
    private Integer read;
    private Integer collection;
    private Integer type;
    private String remark;
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getGoods() {
		return goods;
	}
	public void setGoods(Integer goods) {
		this.goods = goods;
	}
	public Integer getRead() {
		return read;
	}
	public void setRead(Integer read) {
		this.read = read;
	}
	public Integer getCollection() {
		return collection;
	}
	public void setCollection(Integer collection) {
		this.collection = collection;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getComment() {
		return comment;
	}
	public void setComment(Integer comment) {
		this.comment = comment;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private Integer comment;  
    private String source;
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String content;
}
