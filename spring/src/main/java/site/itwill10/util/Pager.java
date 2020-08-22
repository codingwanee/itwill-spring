package site.itwill10.util;

//페이징 처리 관련 값을 저장하기 위한 클래스 
public class Pager {
	//외부 전달값을 이용하여 초기값 저장
	private int pageNum;//출력 페이지 번호
	private int totalArticle;//검색 게시글 갯수
	private int pageSize;//페이지에 검색될 게시글 갯수
	private int blockSize;//블럭에 검색될 페이지 갯수
	
	//필요한 값을 얻기 위한 연산식을 이용하여 초기값 저장
	private int totalPage;//전체 페이지 갯수
	private int startRow;//페이지에 출력될 게시글의 시작 행번호
	private int endRow;//페이지에 출력될 게시글의 종료 행번호
	
	private int startPage;//블럭에 출력될 시작 페이지번호
	private int endPage;//블럭에 출력될 종료 페이지번호
	private int prevPage;//이전 블럭의 시작 페이지번호
	private int nextPage;//다음 블럭의 시작 페이지번호
	
	public Pager(int pageNum, int totalArticle, int pageSize, int blockSize) {
		super();
		this.pageNum = pageNum;
		this.totalArticle = totalArticle;
		this.pageSize = pageSize;
		this.blockSize = blockSize;
		
		calcPager();
	}
	
	private void calcPager() {
		totalPage=(int)Math.ceil((double)totalArticle/pageSize);
		if(pageNum<=0 || pageNum>totalPage) {
			pageNum=1;
		}
		
		startRow=(pageNum-1)*pageSize+1;
		endRow=pageNum*pageSize;
		if(endRow>totalArticle) {
			endRow=totalArticle;
		}
		
		startPage=(pageNum-1)/blockSize*blockSize+1;
		endPage=startPage+blockSize-1;
		if(endPage>totalPage) {
			endPage=totalPage;
		}
		
		prevPage=startPage-blockSize;
		nextPage=startPage+blockSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotalArticle() {
		return totalArticle;
	}

	public void setTotalArticle(int totalArticle) {
		this.totalArticle = totalArticle;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
}



