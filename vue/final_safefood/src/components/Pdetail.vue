<template>
  <div style="margin:50px">
    <div>
      <table class="list_table">
        <col width="10%" />
        <col width="20%" />
        <col width="20%" />
        <col width="20%" />
        <col width="10%" />
        <col width="10%" />
      <tr>
        <th>이미지</th>
         <td style="background-color:white"><img :src="'/'+food.image" width="150px"></td>
      </tr>
      <tr>
        <th>제품명</th><td v-html="food.name"></td>
      </tr>
      <tr>
        <th>제조사</th><td v-html="food.maker"></td>
      </tr>
      <tr>
        <th>원재료</th><td v-html="food.material"></td>
      </tr>
      </table>

    <!-- 찜 목록 -->
        <div class="form-group">
						<label>Quantity</label> <input v-model="amount" type="text" class="form-control" id="qnt" name="qnt" value="1" style="width:50px">
				</div>
        <div class="product elements-list">
          <div @click="update_pick()">
            <input type="button" class="blue btn1" value="찜" />
          </div>
					</div>

<hr style="border:solid 5px">
    <!--  표 시작 -->
    <br>
    <h4 class="space-top">영양 정보</h4>
				<div class="row">
					<div class="col-sm-6">
						<canvas id="myChart" style="max-height: 800px; max-width: 600px;"></canvas>
					</div>
					<div class="col-sm-6">
						<table class="table">

							<tbody>
								<tr>
									<td width="200" style="background-color:white">일일 제공량</td>
									<td>{{food.supportpereat }}</td>
								</tr>
								<tr>
									<td width="200" style="background-color:white">칼로리</td>
									<td>{{food.calory}}</td>
								</tr>
								<tr>
									<td width="200" style="background-color:white">탄수화물</td>
									<td>{{food.carbo}}</td>
								</tr>
								<tr>
									<td width="200" style="background-color:white">단백질</td>
									<td>{{food.protein}}</td>
								</tr>
								<tr>
									<td width="200" style="background-color:white">지방</td>
									<td>{{food.fat}}</td>
								</tr>
								<tr>
									<td width="200" style="background-color:white">당류</td>
									<td>{{food.sugar}}</td>
								</tr>
								<tr>
									<td width="200" style="background-color:white">나트륨</td>
									<td>{{food.natrium}}</td>
								</tr>
								<tr>
									<td width="200" style="background-color:white">콜레스테롤</td>
									<td>{{food.chole}}</td>
								</tr>
								<tr>
									<td width="200" style="background-color:white">포화 지방산</td>
									<td>{{food.fattyacid}}</td>
								</tr>
								<tr>
									<td width="200" style="background-color:white">트랜스지방</td>
									<td>{{food.transfat}}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>


    </div>
  </div>
</template>

<script>
//리스트 받기
import http from "../http-common";
import Chart from "chart.js"

export default {
  name: "fooddetail",
  props: ["code"],
  data() {
    return {
      upHere: false,
      food: {},
      loading: true,
      errored: false,
      userid:localStorage.getItem("saveid"),
      foodcode: this.code,
      amount:''
    };
  },
  methods: {
    update_pick(){
      http
        .post("/insertCart/"+this.userid+"/"+this.foodcode+"/"+this.amount)
        .then(() => {
          alert(this.userid+","+this.foodcode+","+this.amount);
          this.$router.push("/mypick");
          });
    },
    productinfo() {
      http
        .get("/pdetail/"+this.code)
        .then(response => (this.food = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
    refreshList() {
      this.productinfo();
    },
    dynamicColors() {
                var r = Math.floor(Math.random() * 255);
                var g = Math.floor(Math.random() * 255);
                var b = Math.floor(Math.random() * 255);
                return "rgba(" + r + "," + g + "," + b + ",0.8)";
    },
    getFoodBycode() {
        http
          .get("/pdetail/" + this.code)
          .then(response => {
              this.food = response.data;
              const myChart = new Chart("myChart", {
                       type: 'doughnut',
                       data: {
                       labels: ["칼로리", "탄수화물", "단백질", "지방", "당류", "나트륨",
                        "콜레스테롤", "포화 지방산", "트랜스지방"],
                       datasets: [{
                                    label: '# of Votes',
                                    data: [this.food.calory, this.food.carbo, this.food.protein,
                                        this.food.fat, this.food.sugar, this.food.natrium, this
                                        .food.chole, this.food.fattyacid,
                                        this.food.transfat
                                    ],
                                    backgroundColor: [this.dynamicColors(), this.dynamicColors(),
                                        this.dynamicColors(), this.dynamicColors(),
                                        this.dynamicColors(), this.dynamicColors(),
                                        this.dynamicColors(), this.dynamicColors(),
                                        this.dynamicColors()
                                    ],
                                }]
                              },
                       options: {
                                // false >> div의 크기 맞춤.
                                maintainAspectRatio: false,
                                scales: {
                                    yAxes: [{
                                        ticks: { beginAtZero: true}
                                           }]
                                        }
                                }
                        });
                        myChart;
                    })
                    .catch(() => {
                        this.errored = true;
                    })
                    .finally(() => (this.loading = false));
    },
  },
  mounted() {
    this.productinfo();
    this.getFoodBycode();
  }
};
</script>

<style>
</style>
