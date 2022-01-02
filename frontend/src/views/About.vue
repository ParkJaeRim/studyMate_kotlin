<template>
  <div class='about'>
    <b-modal ref="my-modal" hide-footer title="회원가입은 카카오 아이디를 이용해야만 합니다.">
      <b-button class="mt-2" block @click="goSignUp">회원가입 하러 가기</b-button>
      <b-button class="mt-2" block @click="goBackHome">회원가입 하지 않기</b-button>
    </b-modal>

    <h1>This is an about page</h1>
    <b-button id="login-btn" @click="goLogin">로그인</b-button>
    <b-button id="signUp-btn" @click="showModal">회원가입</b-button>
  </div>

</template>

<script>

export default {
  methods: {
    showModal() {
      this.$refs['my-modal'].show();
    },
    goBackHome() {
      this.$refs['my-modal'].hide();
    },
    goLogin() {
      window.location.href = 'https://kauth.kakao.com/oauth/authorize?client_id=d8a07bcf4f4992d4a841f569e9e68f57&redirect_uri=http://localhost:3000/kakaologin&response_type=code';
    },
    goSignUp() {
      window.location.href = 'https://kauth.kakao.com/oauth/authorize?client_id=d8a07bcf4f4992d4a841f569e9e68f57&redirect_uri=http://localhost:3000/signUp&response_type=code';
    },
  },
};

</script>
