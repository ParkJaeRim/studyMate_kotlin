<template>
  <div class='klogin'>
    <h1>엥</h1>
    <br/>{{ form.email }}
    <div>
      <b-form @submit="onSubmit" @reset="onReset" v-if="show">
        <b-form-group
          id="input-group-1"
          label="Email address:"
          label-for="input-1"
          description="We'll never share your email with anyone else."
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

        <b-form-group id="input-group-2" label="Password:" label-for="input-2">
          <b-form-input
            id="input-2"
            v-model="form.password"
            placeholder="Enter password"
            required
          ></b-form-input>
        </b-form-group>

        <b-button type="submit" variant="primary">Submit</b-button>
        <b-button type="reset" variant="danger">Reset</b-button>
      </b-form>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  created() {
    this.create();
  },
  mounted() {
  },
  data() {
    return {
      codes: '',
      form: {
        email: '',
        password: '',
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
        .get(`http://localhost:8080/kakaologin?authorize_code=${this.codes}&redirect_name=kakaologin`)
        .then((res) => {
          this.form.email = res.data.email;
        });
    },
    onSubmit(event) {
      event.preventDefault();
      axios.post('http://localhost:8080/isExist', this.form).then((res) => {
        if (res.data === 'success') {
          alert('로그인 성공');
          this.$router.push('/');
        } else {
          alert('로그인 정보가 틀립니다.');
          this.$router.push('/');
        }
      });
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
