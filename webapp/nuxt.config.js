import {defineNuxtConfig} from 'nuxt/config';

export default defineNuxtConfig({
    modules: [
        '@pinia/nuxt',
        '@pinia-plugin-persistedstate/nuxt',
    ],
    vite: {
        server: {
            proxy: {
                '/api': {
                    target: 'http://localhost:8080/',
                    changeOrigin: true,
                }
            }
        }
    }
})