/**
 *  console.log("Reply Module....");
 */
 
 
 let replyService =(function(){
 	/* 등록 처리 */
 	function add(reply,callback,error){
 		console.log("reply........");
 		
 		$.ajax({
 			type:'post',
 			url:'/replies/new',
 			data: JSON.stringify(reply),
 			contentType:"application/json; charset=utf-8",
 			success : function(result,status,xhr){
 				if(callback){
 					callback(result);
 				}
 			},
 			error : function(xhr,status,er){
 				if(error){
 					error(er);
 				}
 			}
 		})
 	}
 	
 	/* 목록 처리 (getJSON 사용)*/
 	function getList(param, callback, error){
 		var bno = param.bno;
 		var page = param.page || 1 ;
 		
 		$.getJSON("/replies/pages/"+bno+"/"+page+".json",
 			function(data){
 				if(callback){
 					callback(data);
 				}
 			}).fail(function(xhr,status,err){
 			if(error){
 				error();
 			}
 		});
 	}
 	
 	/*  삭제 처리 */
 	function remove(rno,callback,error){
 		$.ajax({
 			type: 'delete',
 			url : '/replies/'+rno,
 			success : function(deleteResult,status,xhr){
 				if(callback){
 					callback(deleteResult);
 				}
 			},
 			error : function(xhr,status,er){
 				if(error){
 					error(er);
 				}
 			}
 		});
 	} 
 	
 	/* 수정 처리 */
 	function update(reply, callback, error){
	 console.log("RNO: "+reply.rno);
	 
	 $.ajax({
		 type : 'put',
	 	 url  : '/replies/' + reply.rno,
	 	 data : JSON.stringify(reply),
	 	 contentType : "application/json; charset=utf-8",
	 	 success: function(result,status,xhr){
	 	 	if(callback){
	 	 		callback(result);
	 	 	}
		 },
		 error: function(xhr,status,er){
		 	if(error){
		 		error(er);
		 	}
		 }
	 });
	}
		
	/* 조회 처리 */
	function get(rno, callback, error){
		$.get("/replies/"+rno +".json",function(result){
			if(callback){
				callback(result);
			}
		}).fail(function(xhr,status,err){
			if(error){
				error();
			}
		});
	}
	
 	return {add     : add,
 			getList : getList,
 			remove  : remove,
 			update  : update,
 			get     : get};  
 }) (); 