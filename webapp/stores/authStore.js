import {defineStore} from "pinia";
import {createError} from "nuxt/app";

export const useAuthStore = defineStore('authStore', {
    state: () => ({
        user: {},
        isLogin: false,
    }),

    actions: {
        async loginUser() {
            // 로그인 API 가 존재하고, 해당 API 를 통해 인증을 했다고 가정한다.
            let response = await fetch('/api/user');
            if (!response.ok) throw createError({
                statusCode: response.statusCode,
                message: response.statusText,
                fatal: true,
            });

            this.user = await response.json();
            this.isLogin = true;
        } ,

        async loginUserForServer() {
            // 로그인 API 가 존재하고, 해당 API 를 통해 인증을 했다고 가정한다.
            let response = await fetch('http://localhost:8080/api/user');
            if (!response.ok) throw createError({
                statusCode: response.statusCode,
                message: response.statusText,
                fatal: true,
            });

            this.user = await response.json();
            this.isLogin = true;
        }
    },

    persist : {
        storage : persistedState.cookiesWithOptions({
            sameSite : 'strict'
        })
    }
})