package snippet;

public class Snippet {
	alter table PSX_NSP_REQUEST_RESULTS_CRMS add maker_id varchar2(50);
	alter table PSX_NSP_REQUEST_RESULTS_CRMS ADD maker_veri_ts TIMESTAMP(6);
	
	alter table PSX_NSP_REQUEST_RESULTS_CRMS add checker_id varchar2(50);
	alter table PSX_NSP_REQUEST_RESULTS_CRMS ADD checker_veri_ts TIMESTAMP(6);
	
	alter table PSX_NSP_REQUEST_RESULTS_CRMS add COMMENTS varchar2(500);
}

