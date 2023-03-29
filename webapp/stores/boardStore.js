import {defineStore} from "pinia";
import {createError , showError} from "nuxt/app";

export const useBoardStore = defineStore('boardStore', {
    state: () => ({
        board: {},
        loading: false
    }),

    getters: {
        getBoard(state) {
            return state.board;
        }
    },

    actions: {
        async fetchDataForServer(id) {
            const data = await fetch(`http://localhost:8080/api/list/${id}`);
            if (!data.ok) throw createError({statusCode: 404, statusMessage: 'Page Not Found!!!!'});
            this.board = await data.json();
            this.loading = true;
        },

        async fetchDataForClient(id) {
            const data = await fetch(`/api/list/${id}`);
            if (!data.ok) throw showError({statusCode: 404, statusMessage: 'Page Not Found!!!!'});
            this.board = await data.json();
            this.loading = true;
        },

        unmountData() {
            this.board = {};
            this.loading = false;
            this.error = false;
        }
    }
})