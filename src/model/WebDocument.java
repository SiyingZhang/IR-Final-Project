/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Zhirun Tian
 */
public class WebDocument {

    private long DocNo;
    private String DocTitle;
    private String DocLink;
    private String DocContent;
    private String DocAbstract;

    public WebDocument(long DocNo, String DocTitle, String DocLink, String DocContent, String DocAbstract) {
        this.DocNo = DocNo;
        this.DocTitle = DocTitle;
        this.DocLink = DocLink;
        this.DocContent = DocContent;
        this.DocAbstract = DocAbstract;
    }
    
    public WebDocument( String DocTitle, String DocLink, String DocContent, String DocAbstract) {
        this.DocNo = 0;
        this.DocTitle = DocTitle;
        this.DocLink = DocLink;
        this.DocContent = DocContent;
        this.DocAbstract = DocAbstract;
    }

    /**
	 * @return the docAbstract
	 */
	public String getDocAbstract() {
		return DocAbstract;
	}

	/**
	 * @param docAbstract the docAbstract to set
	 */
	public void setDocAbstract(String docAbstract) {
		DocAbstract = docAbstract;
	}

	public WebDocument(String DocLink, String DocContent) {

        this.DocLink = DocLink;
        this.DocContent = DocContent;
        this.DocNo = 0;
        this.DocTitle = "no title";
    }

    public WebDocument() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDocContent() {
        return DocContent;
    }

    public void setDocContent(String DocContent) {
        this.DocContent = DocContent;
    }

    public long getDocNo() {
        return DocNo;
    }

    public void setDocNo(long DocNo) {
        this.DocNo = DocNo;
    }

    public String getDocTitle() {
        return DocTitle;
    }

    public void setDocTitle(String DocTitle) {
        this.DocTitle = DocTitle;
    }

    public String getDocLink() {
        return DocLink;
    }

    public void setDocLink(String DocLink) {
        this.DocLink = DocLink;
    }

}
