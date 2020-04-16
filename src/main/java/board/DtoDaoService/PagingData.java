package board.DtoDaoService;

public class PagingData
{
	//페이지당 게시글 수
	private int pageSize = 5;
	
	// 한 range당 페이지의 수
	private int rangeSize = 5;
	
	//현재 페이지
	private int curPage = 1;
	
	//현재 range
	private int curRange = 1;
	
	
	//총 게시글 수
	private int listCnt;
	
	
	//총 페이지 수
	private int pageCnt;
		
	// 총 range 수
	private int rangeCnt;
	
	//시작 페이지
	private int startPage = 1;
	
	//마지막 페이지
	private int endPage= 1;
	
	//시작 인덱스
	private int startIndex;
	
	//이전 페이지
	private int prevPage;
	
	//다음 페이지
	private int nextPage;

	
	public PagingData(int listCnt, int curPage)
	{
		setCurPage(curPage);
		
		setListCnt(listCnt);
		
		setPageCnt(listCnt);
		
		setRangeCnt(curPage);
		
		rangeSetting(curPage);
		
		setStartIndex(curPage);
		
		
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRangeSize() {
		return rangeSize;
	}

	public void setRangeSize(int rangeSize) {
		this.rangeSize = rangeSize;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getCurRange() {
		return curRange;
	}

	public void setCurRange(int curPage) {
		this.curRange = (int)((curPage-1)/rangeSize) + 1;
	}

	public int getListCnt() {
		return listCnt;
	}

	public void setListCnt(int listCnt) {
		this.listCnt = listCnt;
	}
	
	public int getPageCnt() {
		return pageCnt;
	}

	public void setPageCnt(int listCnt) {
		//ceil은 매개변수보다 크거나 같은 숫자중 가장 작은 숫자를 반환 ex ceil(0.95) = 1 // 올림
		this.pageCnt = (int)Math.ceil(listCnt*1.0/pageSize); //10 5 2
	}
	

	public int getRangeCnt() {
		return rangeCnt;
	}

	public void setRangeCnt(int pageCnt) {
		this.rangeCnt = (int)Math.ceil(pageCnt*1.0/rangeSize);//
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

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int curPage) {
		 this.startIndex = (curPage-1) * pageSize;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int curPage) {
		if(curPage > 1)
		{
			this.prevPage -= 1;
		}
		
		else
		{
			prevPage = 0;
		}
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	
	
	public void rangeSetting(int curPage)
	{
		setCurRange(curPage);
		this.startPage = (curRange - 1) * rangeSize + 1;
        this.endPage = startPage + rangeSize - 1;
        
        if(endPage > pageCnt){
            this.endPage = pageCnt;
        }
        
        this.prevPage = curPage - 1;
        this.nextPage = curPage + 1;
	}
}
