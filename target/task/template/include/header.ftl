<div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
        <#if user??>
        	请 please  <a href="/login">  [登录] login</a>
            <#if user.usertype==1>卖家 seller<#else>买家</#if>你好 hello，<span class="name">${user.username}</span>！<a href="/logout">[退出]  logout</a>
        <#else>
            请 please<a href="/login">  [登录] login</a>
        </#if>
        </div>
        <ul class="nav">
            <li><a href="/">首页</a></li>
            <#if user?? && user.usertype==0>
            <li><a href="/account">账务  account</a></li>
            </#if>
            <#if user?? && user.usertype==1>
            <li><a href="/public">发布 public</a></li>
            </#if>
        </ul>
    </div>
</div>