<template>
  <div>
    <h2>注册</h2>
    <form @submit.prevent="register">
      <input v-model="username" placeholder="用户名" required />
      <input type="password" v-model="password" placeholder="密码" required />
      <input v-model="email" placeholder="邮箱" required />
      <button type="submit">注册</button>
    </form>
    <p v-if="error">{{ error }}</p>
    <p v-if="success">注册成功！请登录。</p>
  </div>
</template>

<script setup>
import { ref } from 'vue'

const username = ref('')
const password = ref('')
const email = ref('')
const error = ref('')
const success = ref(false)

async function register() {
  error.value = ''
  success.value = false
  try {
    const res = await fetch('http://localhost:8081/api/user/register', {
      method: 'POST',
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify({
        username: username.value,
        password: password.value,
        email: email.value
      })
    })
    if (!res.ok) {
      const msg = await res.text()
      error.value = msg
      return
    }
    success.value = true
    username.value = ''
    password.value = ''
    email.value = ''
  } catch (e) {
    error.value = '请求失败'
  }
}
</script>
