<template>

<div>
  <div  class="modal-body">
						<div class="cntainer">
							<div class="well">
								<div class="container">
									<form action="" method="post" @submit.prevent="SignUp">
									<div class="form-group">
										<label for="email">IfdfdfdD*:</label> <br />
										<input type="text"
											class="form-control" id="email" name="pid" v-model="cemp.id" readonly>
									</div>
									<div class="form-group">
										<label for="username">이름*</label><br />
										<input type="text"
											id="userId" class="form-control" maxlength="20" value=""
											name="pname" v-model="cemp.name" readonly>
									</div>
									<div class="form-group">
										<label for="useradress">주소*</label><br />
										<input type="text"
											id="userId" class="form-control" maxlength="20" value=""
											name="paddr" v-model="cemp.addr" readonly>
									</div>

									<div class="form-group">
										<label for="useradress">이메일*</label><br />
										<input type="text"
											id="userId" class="form-control" maxlength="20" value=""
											name="paddr" v-model="cemp.email" readonly>
									</div>

									<div class="form-group">
										<label for="useradress">번호*</label><br />
										<input type="text"
											id="userId" class="form-control" maxlength="20" value=""
											name="paddr" v-model="cemp.tel" readonly>
									</div>
									<div class="form-group">
										<label for="useradress">알레르기*</label><br />
										<input type="text"
											id="userId" class="form-control" maxlength="20" value=""
											name="paddr" v-model="cemp.alinfo" readonly>
									</div>
									<div class="modal-footer">

            <router-link  class="btn btn-primary btn-sm" to="/UpdateUser">수정</router-link>
						<router-link algin="right" type="button" class="btn btn-default"
							data-dismiss="modal" to="/">Close</router-link>
					</div>
									</form>
								</div>
							</div>
						</div>
					</div>
</div>
</template>

<script>
import http from "../http-common";

export default {
  name: "search-customer-id",
  data() {
    return {
      info: [],
      loading: true,
      errored: false,
      show:true,
      cid: "",
      cemp: {}
    };
  },
  filters: {
    salarydecimal(value) {
      var a = parseInt(value);
      return a.toFixed(2);
    }
  },
  mounted() {
    http
        .get("/memInfo/" + localStorage.getItem("saveid"))
        .then(response => (this.cemp = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
  },
};
</script>

<style>
.searchform {
  max-width: 300px;
  margin: auto;
}
.search-result {
  margin-top: 20px;
  text-align: left;
}
</style>