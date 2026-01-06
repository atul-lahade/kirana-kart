import { makeAutoObservable } from 'mobx'
import { RootStore } from './RootStore'

export type ToastType = 'success' | 'error' | 'info' | 'warning'

export interface Toast {
  id: string
  message: string
  type: ToastType
  duration?: number
}

export class UIStore {
  rootStore: RootStore
  toasts: Toast[] = []
  isSidebarOpen = false
  isModalOpen = false
  modalContent: React.ReactNode | null = null

  constructor(rootStore: RootStore) {
    this.rootStore = rootStore
    makeAutoObservable(this)
  }

  showToast(message: string, type: ToastType = 'info', duration = 3000) {
    const id = Math.random().toString(36).substr(2, 9)
    const toast: Toast = { id, message, type, duration }

    this.toasts.push(toast)

    if (duration > 0) {
      setTimeout(() => {
        this.removeToast(id)
      }, duration)
    }
  }

  removeToast(id: string) {
    this.toasts = this.toasts.filter((toast) => toast.id !== id)
  }

  toggleSidebar() {
    this.isSidebarOpen = !this.isSidebarOpen
  }

  openModal(content: React.ReactNode) {
    this.modalContent = content
    this.isModalOpen = true
  }

  closeModal() {
    this.isModalOpen = false
    this.modalContent = null
  }
}