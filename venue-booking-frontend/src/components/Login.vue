<template>
    <div>
      <h2>登录</h2>
      <form @submit.prevent="login">
        <input v-model="username" placeholder="用户名" required />
        <input type="password" v-model="password" placeholder="密码" required />
        <select v-model="role">
          <option value="user">用户</option>
          <option value="admin">管理员</option>
        </select>
        <button type="submit">登录</button>
      </form>
      <p v-if="error">{{ error }}</p>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue'
  
  const username = ref('')
  const password = ref('')
  const role = ref('user')
  const error = ref('')
  
  async function login() {
    error.value = ''
    const url = role.value === 'admin' ? 'http://localhost:8081/api/admin/login' : 'http://localhost:8081/api/user/login'
    try {
      const res = await fetch(url, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
          username: username.value,
          password: password.value
        })
      })
      if (!res.ok) {
        const msg = await res.text()
        error.value = msg
        return
      }
      const data = await res.json()
      alert(`登录成功，欢迎${data.username || '管理员'}`)
    } catch (e) {
      error.value = '请求失败'
    }
  }
  </script>
  