/**
 * 
 */
package dto;

/**
 * @author vlads
 *
 */
public class AnswerDto {

	private Long userId;
	
	private Long pollId;
	
	String content;
	
	int vottingDetail;
	
	public AnswerDto() {
		
	}
	
	/**
	 * @return the comment
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the vottingDetail
	 */
	public int getVottingDetail() {
		return vottingDetail;
	}

	/**
	 * @param vottingDetail the vottingDetail to set
	 */
	public void setVottingDetail(int vottingDetail) {
		this.vottingDetail = vottingDetail;
	}

	

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the pollId
	 */
	public Long getPollId() {
		return pollId;
	}

	/**
	 * @param pollId the pollId to set
	 */
	public void setPollId(Long pollId) {
		this.pollId = pollId;
	}
	
	
	
	
}
