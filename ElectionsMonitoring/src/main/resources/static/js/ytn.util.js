/**
	util
	@author : mattmk
*/

$(function(){
	//leftMenuDept 설정함수 호출.
	leftMenuCookieSet();
});

/**
 * leftMenuDept 설정.
 * @author : mattmk
 */
function leftMenuCookieSet(){
	// 초기화
	/*
	$('.active').removeClass('active');
	$('.collapse.show').removeClass('show');
	$('a[aria-expanded=true]').addClass('collapsed');
	$('a[aria-expanded=true]').attr('aria-expanded','false');
	*/

	// 생성
	$('#'+$.cookie('leftMenuDept')).parents('li').children('a').removeClass('collapsed');
	$('#'+$.cookie('leftMenuDept')).addClass('active');
	$('#'+$.cookie('leftMenuDept')).parents('li').addClass('active');

	$('#'+$.cookie('leftMenuDept')).parents('div').eq(1).addClass('show')
	//$('#'+$.cookie('leftMenuDept')).parents('div').find('.collapse').addClass('show');

	$('.collapse-item').on('click', function () {
		// cookie 셋팅.
		$.cookie('leftMenuDept',$(this).attr('id'));
	});
}

/**
 * 공통 Cookie 삭제.
 * @author : mattmk
 */
 function cookieDelAll(){
	$.removeCookie('leftMenuDept');
}

/**
 * 로그아웃 이벤트 함수.
 * @author : mattmk
 */
$('#logoutBtn').on('click', function () {
	// 공통 Cookie 삭제함수 호출.
	cookieDelAll();
});


