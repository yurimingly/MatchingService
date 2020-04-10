
    function nameCheck() {
    	var id=document.getElementById('name');
    	var v=id.value;
    	var l=id.value.length;
        if (l >9) {		
            alert("이름은 10글자 이내만 가능합니다.");
            id.value=v.substring(0,9);
            id.focus();
            return false;
        }
        return true;
    }
    function passwordCheck(){
    	var id=document.getElementById('password');
    	var v=id.value;
    	var l=id.value.length;
        if (l >19) {		
            alert("비밀번호는 20글자 이내만 가능합니다.");
            id.value=v.substring(0,19);
            id.focus();
            return false;
        }
        return true;
    }
    function rePasswordCheck(){
    	var id=document.getElementById('reCheck');
    	var v=id.value;
    	var l=id.value.length;
        if (l >19) {		
            alert("20글자 이내만 가능합니다.");
            id.value=v.substring(0,19);
            id.focus();
            return false;
        }
        return true;
    }
    function eCheck(){
    	var id=document.getElementById('s_email');
    	var v=id.value;
    	var l=id.value.length;
        if (l >19) {		
            alert("이메일은 20글자 이내만 가능합니다.");
            id.value=v.substring(0,19);
            id.focus();
            return false;
        }
        
        return true;
    }
    function pCheck(){
    	var id=document.getElementById('s_phone');
    	var v=id.value;
    	var l=id.value.length;
        if (l >12) {		
            alert("000-0000-0000의 형식으로 입력해 주세요.");
            id.value=v.substring(0,12);
            id.focus();
            return false;
        }
        return true;
    }
	