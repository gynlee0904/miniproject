function cardinfo_menu(id, part) {
	var card_menu = document.getElementById(id);
	if (part == 1) {
		if (card_menu.style.display == "none") {
			card_menu.style.display = "block";
		}
		else {
			card_menu.style.display = "none";
		}
	}
	else {
		card_menu.style.display = "none";
	}
}

var http, result;
//일간카드
function dailyProduct(){
	http = new XMLHttpRequest();
	http.open("GET","./md_compare.do",false); 
	http.setRequestHeader("content-type","application/json"),
	http.onload = function () {
        if (http.readyState == 4) { // 요청 완료
		console.log("result : "+http.status);
            if (http.status == 200) {
                result = JSON.parse(this.response);

                var cardTitle = "매물 등록수 <span class='date'>| Today</span>";
                var today_total = result.today_total;
                var yesterday_total = result.yesterday_total;

                document.getElementById("card_title").innerHTML = cardTitle;
                document.getElementById("allCnt").textContent = today_total + ' 개';

				var contentToDisplay = "";

                if (yesterday_total !== 0) {
                    var percentageChange = ((today_total - yesterday_total) / yesterday_total) * 100;
                    var absolutePercentageChange = Math.abs(percentageChange);
                    var displayText = absolutePercentageChange.toFixed(0) + "%";
                    document.getElementById("insert_pd_result").textContent = displayText;
                } else {
                    contentToDisplay = "어제 등록된 추천매물수는 0개입니다";
                    document.getElementById("insert_pd_result").innerHTML = contentToDisplay;
                }

                var changeText = "";

                if (today_total > yesterday_total) {
                    changeText = "increase";
                } else if (today_total < yesterday_total) {
                    changeText = "decrease";
                } else {
                    changeText = "same";
                }

                document.getElementById("change_result").textContent = changeText;

            } else {
                alert("에러가 발생했습니다");
                console.log("상태 코드:", http.status);
            }
        }
    }
	http.send();
}


//주간카드
function weeklyProduct(){
	http = new XMLHttpRequest();
	http.open("GET","./md_compare_week.do",false); 
	http.setRequestHeader("content-type","application/json"),
	http.onload = function () {
        if (http.readyState == 4) { // 요청 완료
            if (http.status == 200) {
                result = JSON.parse(this.response);
                console.log(result);

                var cardTitle = "매물 등록수 <span class='date'>| Week</span>";
                var thisweekly_total = result.thisweekly_total;
                var lastweekly_total = result.lastweekly_total;

                document.getElementById("card_title").innerHTML = cardTitle;
                document.getElementById("allCnt").textContent = thisweekly_total + ' 개';

				var contentToDisplay = "";

                if (lastweekly_total !== 0) {
                    var percentageChange = ((thisweekly_total - lastweekly_total) / lastweekly_total) * 100;
                    var absolutePercentageChange = Math.abs(percentageChange);
                    var displayText = absolutePercentageChange.toFixed(0) + "%";
                    document.getElementById("insert_pd_result").textContent = displayText;
                } else {
                    contentToDisplay = "지난주 등록된 추천매물수는 0개입니다";
                    document.getElementById("insert_pd_result").innerHTML = contentToDisplay;
                }

                var changeText = "";

                if (thisweekly_total > lastweekly_total) {
                    changeText = "increase";
                } else if (thisweekly_total < lastweekly_total) {
                    changeText = "decrease";
                } else {
                    changeText = "same";
                }

                document.getElementById("change_result").textContent = changeText;

            } else {
                alert("에러가 발생했습니다");
                console.log("상태 코드:", http.status);
            }
        }
    }
    http.send();
}












window.onload=function(){
	//그래프 차트
	var http2 = new XMLHttpRequest();
	http2.open("GET", "./column_chart.do", false);
	http2.onload = function () {
        if(http2.readyState == 4 && http2.status == 200) { // 요청 완료
           var result2 = JSON.parse(this.response);
			console.log(result2);

 			var dayList = result2.dayCountList.date;
            var mdList = result2.dayCountList.md_cnt;
            var rvList = result2.dayCountList.rv_cnt;
			var dealList = result2.dayCountList.rv_cnt;

			google.charts.load('current', {'packages':['bar']});
			google.charts.setOnLoadCallback(drawChart);
           
			function drawChart() {
			   const dataArray = [
                    ['날짜', '등록개수', '방문예약수','거래수']
                ];

                for (let i = 0; i < dayList.length; i++) {
                    dataArray.push([dayList[i], mdList[i], rvList[i],dealList[i]]);
                }

                var data = google.visualization.arrayToDataTable(dataArray);

                var options = {
                    chart: {
                        
                    }
                };

                var chart = new google.charts.Bar(document.getElementById('columnchart_material'));
                chart.draw(data, google.charts.Bar.convertOptions(options));
			}
      	}else {
            alert("에러가 발생했습니다ccc");
            console.log("상태 코드:", http.status);
        }
    }
    http2.send();
	
	
	
	//도넛차트1
	http = new XMLHttpRequest();
	http.open("GET", "./donut_chart1.do", false);
	http.setRequestHeader("content-type","application/json; charset=UTF-8");
	http.onload = function () {
        if(http.readyState == 4 && http.status == 200) { // 요청 완료
            result = JSON.parse(this.response);
				
			var countArr = result.rental.count;
            var categoryArr = result.rental.category;
		
			const donutchart1 = document.getElementById('donut_chart1');
			new Chart(donutchart1, {
				type: 'doughnut',
				data: {
					labels:  categoryArr,
					datasets: [{
						label: '문의건수  ',
						data: countArr,
						backgroundColor: [
							'rgb(255, 99, 132)',
							'rgb(54, 162, 235)',
							'rgb(255, 205, 86)',
							'rgb(153,102,255)'
						],
						hoverOffset: 4
					}]
				},
				options: { scales: { y: { } } }
			})
		
      	}else {
            alert("에러가 발생했습니다ccc");
            console.log("상태 코드:", http.status);
        }
    }
    http.send();
};





const donutchart2 = document.getElementById('donut_chart2');

new Chart(donutchart2, {
	type: 'doughnut',
	data: {
		labels: ['임시1', '임시2', '임시3', '임시4', '임시5', '임시6'],
		datasets: [{
			label: '# of Votes',
			data: [12, 19, 3, 5, 2, 3],
			borderWidth: 1
		}]
	},
	options: {
		scales: {
			y: {
				beginAtZero: true
			}
		}
	}
});
