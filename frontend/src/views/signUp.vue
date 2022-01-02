<template>
  <div class='signUp'>
    <div>
      <b-form @submit="onSubmit" @reset="onReset" v-if="show">
        <b-form-group
          id="input-group-1"
          label="이메일 주소:"
          label-for="input-1"
        >
          <b-form-input
            id="input-1"
            v-model="form.email"
            type="email"
            v-text="form.email"
            required
            disabled
          >
          </b-form-input>
        </b-form-group>

        <b-form-group id="input-group-2" label="비밀번호:" label-for="input-2">
          <b-form-input
            id="input-2"
            v-model="form.password"
            placeholder="비밀번호를 입력해주세요"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-3" label="이름:" label-for="input-3">
          <b-form-input
            id="input-3"
            v-model="form.realName"
            placeholder="실명을 입력해주세요"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-4" label="닉네임:" label-for="input-4">
          <b-form-input
            id="input-4"
            v-model="form.nickname"
            placeholder="닉네임을 입력해주세요"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-5" label="자기소개:" label-for="input-5">
          <b-form-textarea
            id="input-5"
            v-model="form.introduction"
            placeholder="자기소개"
            required
          ></b-form-textarea>
        </b-form-group>

<!--        <b-form-group id="input-group-6" label="프로필이미지:" label-for="input-6">-->
<!--          <b-form-file-->
<!--            id="input-6"-->
<!--            v-model="form.profileImage"-->
<!--            placeholder="프로필이미지"-->
<!--          ></b-form-file>-->
<!--        </b-form-group>-->

        <b-button type="submit" variant="primary">Submit</b-button>
        <b-button type="reset" variant="danger">Reset</b-button>
      </b-form>
    </div>
  </div>
</template>

<!--모달로 카카오로 회원가입해야만합니다. 거부 시, 홈으로 돌아갑니다.-->
<script>
import axios from 'axios';

export default {
  created() {
    this.create();
  },
  data() {
    return {
      codes: '',
      form: {
        email: '',
        password: '',
        realName: '',
        nickname: '',
        introduction: '',
        // profileImage: null,
      },
      show: true,
    };
  },
  methods: {
    create() {
      this.codes = this.$route.query.code;
      this.getToken();
    },
    getToken() {
      axios
        .get(`http://localhost:8080/kakaologin?authorize_code=${this.codes}&redirect_name=signUp`)
        .then((res) => {
          this.form.email = res.data.email;
        });
    },
    onSubmit(event) {
      event.preventDefault();
      axios.post('http://localhost:8080/join', this.form).then(
        this.$router.push('/'),
      );
    },
    onReset(event) {
      event.preventDefault();
      this.form.password = '';
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    },
  },
};
</script>
