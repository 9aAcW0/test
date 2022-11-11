<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style type="text/css" media="screen">
        @import url("/css/global.css");
        @import url("/css/corporateDetail.css");
    </style>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.9.1/chart.min.js" integrity="sha512-ElRFoEQdI5Ht6kZvyzXhYG9NqjtkmlkfYk0wr6wHxU9JEHakS7UJZNeml5ALk+8IKlU6jDgMabC3vkumRokgJA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

</head>
<body>
<script>
    function diagnosisClick() {

        alert("button clicked");

        var dia = document.getElementById('Diagnosis');
        dia.className = 'diagnosisCheck'
        var mem = document.getElementById('Member')
        mem.className = 'memberUncheck';
        var mResult = document.getElementById('member-result')
        mResult.className = 'member-resultUncheck';
        var dResult = document.getElementById('diagnosis-result')
        dResult.className = 'diagnosis-resultCheck';
        dia.disabled = true;
        mem.disabled = false;
    }

    function memberClick() {

        alert("button clicked");

        var dia = document.getElementById('Diagnosis');
        dia.className = 'diagnosis';
        var mem = document.getElementById('Member')
        mem.className = 'member';
        var mResult = document.getElementById('member-result')
        mResult.className = 'memberResult';
        var dResult = document.getElementById('diagnosis-result')
        dResult.className = 'diagnosis-result';
        var bChart = document.getElementById('business')
        bChart.className = 'businessUncheck';
        var pChart = document.getElementById('personality')
        pChart.className = 'personalityUncheck';
        mem.disabled = true;
        dia.disabled = false;
    }

    function bDetailViewClick() {

        alert("button clicked");
        var mem = document.getElementById('Member')
        var dResult = document.getElementById('diagnosis-result')
        dResult.className = 'diagnosis-result';
        var bChart = document.getElementById('business')
        bChart.className = 'business';
        mem.disabled = false;
    }
    function pDetailViewClick() {

        alert("button clicked");
        var mem = document.getElementById('Member')
        var dResult = document.getElementById('diagnosis-result')
        dResult.className = 'diagnosis-result';
        var pChart = document.getElementById('personality')
        pChart.className = 'personality';
        mem.disabled = false;
    }

    function backListClick() {
        alert("button clicked");
        var dResult = document.getElementById('diagnosis-result')
        dResult.className = 'diagnosis-resultCheck';
        var bChart = document.getElementById('business')
        bChart.className = 'businessUncheck';
        var pChart = document.getElementById('personality')
        pChart.className = 'personalityUncheck';
    }

</script>


<div class="imgFrame">
    <img src="/img/lilistyle_logo_yoko_rgb.png">
</div>
<div class="content">
    <div class="text-box">
        <h2>会員管理</h2>
        <h3>会員一覧 > 会員情報詳細</h3>
    </div>
    <div class="user-box">
        <div class="user-header">
            <p class="name"> 名前:　{{ .Name }}</p>
        </div>
        <div class="detail-box">
            <div class="detail-header">
                <button id="Member" class="header-name member" onclick="memberClick()">会員情報</button>
                <button id="Diagnosis" class="header-name diagnosis" onclick=diagnosisClick()>診断結果</button>
            </div>
            <div class="detail-content">
                <div id="member-result" class="memberResult">
                    <table class="left-table">
                    <tr>
                        <td class="type"><p>ユーザータイプ</p></td>
                        <td class="Data"><p>{{ .Class }}</p></td>
                    </tr>
                    {{ if eq .Class "学生"}}
                    <tr>
                        <td class="type"><p>大学名</p></td>
                        <td class="Data"><p>{{ .University }}</p></td>
                    </tr>
                    <tr>
                        <td class="type"><p>学部</p></td>
                        <td class="Data"><p>{{ .UnderGraduate }}</p></td>
                    </tr>
                    <tr>
                        <td class="type"><p>学科</p></td>
                        <td class="Data"><p>{{ .Department }}</p></td>
                    </tr>
                    <tr>
                        <td class="type"><p>卒業年度</p></td>
                        <td class="Data"><p>{{ .GraduationYear }}</p></td>
                    </tr>
                    {{ else if eq .Class "採用候補者"}}
                    <tr>
                        <td class="type"><p>現在のお勤め先</p></td>
                        <td class="Data"><p>{{ .CurrentEmployer }}</p></td>
                    </tr>
                    {{ end }}
                    <tr>
                        <td class="type"><p>電話番号</p></td>
                        <td class="Data"><p>{{ .Tel }}</p></td>
                    </tr>
                    <tr>
                        <td class="type"><p>メールアドレス</p></td>
                        <td class="Data"><p>{{ .Mail }}</p></td>
                    </tr>
                </table>
                <table class="right-table">
                    <tr>
                        <td class="type"><p>追加日</p></td>
                        <td class="Data"><p>{{ .TimeStamp }}</p></td>
                    </tr>
                    <tr>
                        <td class="type"><p>詳細の希望年収</p></td>
                        <td class="Data"><p>{{ .CarrierUp.Fifteen }}</p></td>
                    </tr>
                </table>
                </div>
                <div id="diagnosis-result" class="diagnosis-result">
                    <h2>診断結果一覧</h2>
                    <table class="user-table" >
                        <tr class="table-header">
                            <th class="title"><p>診断内容</p></th>
                            <th class="addDate"><p>診断日時</p></th>
                            <th></th>
                        </tr>
                        {{ if .Altruism }}
                        <tr>
                            <td class="title"><p>市場価値診断</p></td>
                            <td class="addDate"><p>{{ .TimeStamp}}</p></td>
                            <td class="detail-button"><button onclick="bDetailViewClick()">詳細</button></td>
                        </tr>
                        {{ end }}
                        {{ if .Personality }}
                        <tr>
                            <td class="title"><p>パーソナリティ傾向診断</p></td>
                            <td class="addDate"><p>{{ .TimeStamp}}</p></td>
                            <td class="detail-button"><button onclick=pDetailViewClick()>詳細</button></td>
                        </tr>
                        {{ end }}
                    </table>
                </div>
                <div id="business" class="chart businessUncheck">
                    <h2>市場価値診断</h2>
                    <div class="businessFrame">
                    <canvas id="BusinessChart" width="400" height="400" >
                        <script class="chart">
                            var ctx = document.getElementById("BusinessChart");
                            var myRadarChart = new Chart(ctx, {
                                //グラフの種類
                                type: 'radar',
                                //データの設定
                                data: {
                                    labels: ['キャリアアップ指数', 'ビジネススタンス指数', '利他指数', 'コミット指数', 'メンタリティ指数'],
                                    datasets: [{
                                        label: '市場価値診断',
                                        //グラフのデータ
                                        data: [{{.CarrierUp.Rate}}, {{.BusinessStance.Rate}}, {{.Altruism.Rate}}, {{.Commit.Rate}}, {{.Mentality.Rate}}],
                            // データライン
                            borderColor: 'red',
                            }],
                            },
                            //オプションの設定
                            options: {
                                scales: {
                                    r: {
                                        //グラフの最小値・最大値
                                        min: 0,
                                            max: 10,
                                            //背景色
                                            backgroundColor: '#D1D5DB',
                                            //グリッドライン
                                            grid: {
                                            color: '#6B7280',
                                        },
                                        //アングルライン
                                        angleLines: {
                                            color: '#6B7280',
                                        },
                                        //各項目のラベル
                                        pointLabels: {
                                            color: '#6B7280',
                                        },
                                    },
                                },
                            },
                            });
                        </script>
                    </canvas>
                </div>
                    <div class="button-block">
                        <button class="backList" onclick="backListClick()">診断結果一覧に戻る</button>
                    </div>
                </div>
                <div id="personality" class="chart personalityUncheck">
                    <h2>パーソナリティ診断</h2>
                    <div class="personalityFrame">
                    <canvas id="PersonalityChart" width="400" height="400" >
                        <script class="chart">
                            var ctx = document.getElementById("PersonalityChart");
                            var myRadarChart2 = new Chart(ctx, {
                                //グラフの種類
                                type: 'radar',
                                //データの設定
                                data: {
                                    labels: ['厳格度', '受容度', '論理度', '自由度', '調和度'],
                                    datasets: [{
                                        label: 'パーソナリティ傾向診断',
                                        //グラフのデータ
                                        data: [{{.Personality.RigorRate}}, {{.Personality.AcceptabilityRate
                                    }}, {{.Personality.LogicalityRate}}, {{.Personality.FreedomRate}}, {{.Personality.CoordinationRate}}],
                            // データライン
                            borderColor: 'red',
                            }],
                            },
                            //オプションの設定
                            options: {
                                scales: {
                                    r: {
                                        //グラフの最小値・最大値
                                        min: 0,
                                            max: 10,
                                            //背景色
                                            backgroundColor: '#D1D5DB',
                                            //グリッドライン
                                            grid: {
                                            color: '#6B7280',
                                        },
                                        //アングルライン
                                        angleLines: {
                                            color: '#6B7280',
                                        },
                                        //各項目のラベル
                                        pointLabels: {
                                            color: '#6B7280',
                                        },
                                    },
                                },
                            },
                            });
                        </script>
                    </canvas>
                </div>
                    <div class="button-block">
                    <button class="backList" onclick=backListClick()>診断結果一覧に戻る</button>
                    </div>
                </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>