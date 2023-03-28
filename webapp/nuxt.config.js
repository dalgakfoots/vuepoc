import {defineNuxtConfig} from 'nuxt/config';

export default defineNuxtConfig({
    modules : [
      '@pinia/nuxt',
    ],
    vite: {
        server: {
            proxy: {
                '/api': {
                    target : 'http://localhost:8080/',
                    changeOrigin : true,
                }
            }
        }
    }
})