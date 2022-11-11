<!DOCTYPE html>
<html>
    <head>
        <style type="text/css" media="screen">

            @import url("/js/chart.js");
            @import url("/js/main.js");
            @import url("/css/user.css");
            @import url("/css/global.css");
        </style>
        <meta>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.9.1/chart.min.js" integrity="sha512-ElRFoEQdI5Ht6kZvyzXhYG9NqjtkmlkfYk0wr6wHxU9JEHakS7UJZNeml5ALk+8IKlU6jDgMabC3vkumRokgJA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    </head>
    <body>
        <div class="imgFrame">
            <img src="/img/lilistyle_logo_yoko_rgb.png">
        </div>
        <div class="header">
            <h1>診断結果</h1>
            <h2> {{.Name}} さん</h2>
        </div>
        <div class="result">
            <div class="chartFrame">
        <canvas id="myRadarChart" width="400" height="400" >
        <script class="chart">
            var ctx = document.getElementById("myRadarChart");
            var myRadarChart = new Chart(ctx, {
                //グラフの種類
                type: 'radar',
                //データの設定
                data: {
                    labels: ['ビジネススタンス指数', '利他指数', 'キャリアアップ指数', 'メンタリティ指数','コミット指数'],
                    datasets: [{
                        label: '市場価値診断',
                        //グラフのデータ
                        data: [{{.BusinessStance.Rate}}, {{.Altruism.Rate}}, {{.CarrierUp.Rate}}, {{.Mentality.Rate}} ,{{.Commit.Rate}}],
                        // データライン
                        borderColor: 'red',
                        backgroundColor: "rgba(255, 0, 0, 0.3)",
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
        <div class="description">
            <p>「キャリアアップ指数」は、キャリアにおける目標の高さ・成長意欲の強さを表しています。キャリアアップ指数が高い方は、目標達成への熱量が高く、結果にこだわり努力し続ける方だと言えます。</p>
            <p>「ビジネススタンス指数」は、戦略的に物事を考える力の強さを表しています。ビジネススタンス指数の高い方は、他者貢献意欲が高く、長期的かつ俯瞰的に物事を捉えて戦略を練り、具体的なアクションに落とし込むことができます。</p>
            <p>「コミット指数」は、目標に対して確実な結果を出すため最大限の努力ができる人を表しています。コミット指数の高い方は、目標を達成する意欲が強く、困難な状況に置かれても、諦めず努力し続けることができるでしょう。</p>
            <p>「利他指数」は、人のために動きたいと思う力の強さを表しています。利他指数の高い方は、素直さをもち、自分自身を信じている状態であり、その上で周囲の人に対して謙虚に、自分ができることを一所懸命に考えます。</p>
            <p>「メンタリティ指数」は、自己肯定感の高さを表しています。メンタリティ指数が高い方は、ストレス耐性が強く、セルフコントロール力があるため、感情の浮き沈みに左右されることが少ないと言えます。</p>
        </div>
        </div>
        <div class="result">
        <div class="chartFrame">
        <canvas id="myRadarChart2" width="400" height="400" >
        <script class="chart">
            var ctx = document.getElementById("myRadarChart2");
            var myRadarChart2 = new Chart(ctx, {
                //グラフの種類
                type: 'radar',
                //データの設定
                data: {
                    labels: ['リーダーシップ力', '共感力', '思考力', '感性力', 'チームワーク力'],
                    datasets: [{
                        label: 'パーソナリティ傾向診断',
                        //グラフのデータ
                        data: [{{.Personality.RigorRate}}, {{.Personality.AcceptabilityRate
                        }}, {{.Personality.LogicalityRate}}, {{.Personality.FreedomRate}}, {{.Personality.CoordinationRate}}],
                            // データライン
                            borderColor: 'red',
                            backgroundColor: "rgba(255, 0, 0, 0.3)",
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
        <div class="description">
            <p>「リーダーシップ力」は、責任感の強さ、物事を最後までやり切る力を表します。リーダーシップ力が強い方は、結果にこだわり、仕事で良いパフォーマンスを上げることができるでしょう。</p>
            <p>「共感力」は、人への関心の強さ・寛容さを表します。共感力が強い人は、優しい心を持ち、人の気持ちに寄り添うことで、周囲の人からも大切にしてもらえる人です。</p>
            <p>「思考力」は、論理的に物事を捉え、分析できる力を指します。思考力の強い方は、戦略や改善案を考えることが非常に得意で、課題を解決に導くことができます。また、自分自身の感情も思考でコントロールすることができます。</p>
            <p>「感性力」は、感覚的な察する力・イメージする力の強さを表します。感性力が強い方は、まだ世に出ていないような革新的なアイデアを生み出す力を持っています。また、人の気持ちを感じ取る力が強く、営業・接客業などの場面においてはお客様の要望に沿った提案やゼロイチ発想をできる可能性を秘めています。</p>
            <p>「チームワーク力」は、協調性の強さを指します。他人の意見を尊重することで、チームワーク力の強い方は、人と一緒に物事を成し遂げることが得意と言えます。</p>
        </div>
        </div>
    </body>
</html>
