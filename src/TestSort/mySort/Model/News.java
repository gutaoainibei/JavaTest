package TestSort.mySort.Model;

import java.util.Date;
/**
 * 
 * 描述：新闻模型类
 * @author gt
 * @created 2016年3月8日 下午4:07:38
 * @since
 */
public class News {
	private String title;
	private Date createTime;
	private int hits;

	public News() {
		super();
	}

	public News(String title, Date createTime, int hits) {
      this.title = title;
      this.createTime = createTime;
      this.hits = hits;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	@Override
	public String toString() {
		return "News [title=" + title + ", createTime=" + createTime
				+ ", hits=" + hits + "]";
	}

}
