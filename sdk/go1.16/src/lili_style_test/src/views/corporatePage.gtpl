<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <style type="text/css" media="screen">
        @import url("/css/global.css");
        @import url("/css/corporate.css");
    </style>
</head>
<body>
<div class="imgFrame">
    <img src="/img/lilistyle_logo_yoko_rgb.png">
</div>
<div class="content">
    <div class="text-box">
    <h2>会員管理</h2>
    <h3>会員一覧</h3>
    </div>
    <table class="user-table" >
        <tr class="table-header">
            <th class="name"><p>名前</p></th>
            <th class="type"><p>ユーザータイプ</p></th>
            <th class="addDate"><p>追加日</p></th>
            <th></th>
        </tr>
        {{ range . }}
        <tr>
            <th class="name"><p>{{.Name}}</p></th>
            <th class="type"><p>{{.Class}}</p></th>
            <th class="addDate"><p>{{.TimeStamp}}</p></th>
            <th class="detail">
                {{$Mail := .Mail }}
                <form method="POST" action="/corporate/userDetail">
                    <input class="place" type="text" name="mail" value={{ .Mail }}>
                    <input class="button" type="submit" value="詳細">
                </form>
            </th>

        </tr>
        {{ end }}
    </table>
</div>
</body>
</html>