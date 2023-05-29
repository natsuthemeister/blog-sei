//特定のタブしか開かない
function openTab(event, tabId, redirectUrl) {
    var i, tabContent, tabLinks;

    // タブ内容を隠す
    tabContent = document.getElementsByClassName("tabContent");
    for (i = 0; i < tabContent.length; i++) {
        tabContent[i].style.display = "none";
    }

    // 全タブから開いたタブを外す
    tabLinks = document.getElementsByClassName("tabLinks");
    for (i = 0; i < tabLinks.length; i++) {
        tabLinks[i].className = tabLinks[i].className.replace(" active", "");
    }

    // クリックされたタブを開き、内容を示す
    document.getElementById(tabId).style.display = "block";
    event.currentTarget.className += " active";

    // リダイレクトが指定されている場合のみリダイレクトを行う
    if (redirectUrl) {
        location.href = redirectUrl;
    }
}

//最初のタブは常に開く
document.getElementsByClassName("tabLinks")[0].click();