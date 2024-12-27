<script setup lang="ts">

</script>

<template>
  <!-- Main Content -->
  <div class="flex-1 flex flex-col">
    <!-- Header -->
    <header class="bg-white shadow p-4 flex justify-between items-center">
      <h2 class="text-xl font-semibold text-blue-500">Task Manager</h2>
      <div class="flex items-center space-x-4">
        <button class="bg-blue-500 text-white px-4 py-2 rounded-md">Add Task</button>
        <img
            src="https://via.placeholder.com/40"
            alt="User Avatar"
            class="w-10 h-10 rounded-full border"
        />
      </div>
    </header>

    <!-- Content -->
    <main class="p-6 space-y-6">
      <!-- Task Overview -->
      <div class="grid grid-cols-3 gap-6">
        <div class="bg-white p-5 rounded shadow">
          <h3 class="text-lg font-medium text-gray-700">Completed</h3>
          <p class="text-2xl font-bold text-blue-600">12</p>
        </div>
        <div class="bg-white p-5 rounded shadow">
          <h3 class="text-lg font-medium text-gray-700">Pending</h3>
          <p class="text-2xl font-bold text-yellow-500">8</p>
        </div>
        <div class="bg-white p-5 rounded shadow">
          <h3 class="text-lg font-medium text-gray-700">Overdue</h3>
          <p class="text-2xl font-bold text-red-500">3</p>
        </div>
      </div>

      <!-- Task List -->
      <div>
        <h3 class="text-lg font-medium text-gray-700 mb-4">Tasks</h3>
        <div class="bg-white p-4 rounded shadow divide-y">
          <div class="py-4 flex justify-between items-center">
            <div>
              <h4 class="font-medium text-gray-700">Design Homepage</h4>
              <p class="text-sm text-gray-500">Due: Dec 28, 2024</p>
            </div>
            <span class="text-blue-500 text-sm">In Progress</span>
          </div>
          <div class="py-4 flex justify-between items-center">
            <div>
              <h4 class="font-medium text-gray-700">Write Blog Post</h4>
              <p class="text-sm text-gray-500">Due: Jan 2, 2025</p>
            </div>
            <span class="text-yellow-500 text-sm">Pending</span>
          </div>
          <div class="py-4 flex justify-between items-center">
            <div>
              <h4 class="font-medium text-gray-700">Fix Bugs</h4>
              <p class="text-sm text-gray-500">Due: Dec 26, 2024</p>
            </div>
            <span class="text-red-500 text-sm">Overdue</span>
          </div>
        </div>
      </div>

      <!-- Board -->
      <div>
        <h3 class="text-lg font-medium text-gray-700 mb-4">Board</h3>
        <div class="grid grid-cols-4 gap-6">
          <div class="bg-white p-5 rounded shadow">
            <h3 class="text-lg font-medium text-gray-700 mb-4 border-b-2">To Do</h3>
            <div class="py-1 flex flex-col">
              <div class="border mb-1 px-4 py-6">
                Content
              </div>
              <div class="border">
                Content
              </div>
            </div>
          </div>
          <div class="bg-white p-5 rounded shadow">
            <h3 class="text-lg font-medium text-gray-700 mb-4 border-b-2">To Do</h3>
            <div class="py-1 flex flex-col">
              <div class="border mb-1 px-4 py-6">
                Content
              </div>
              <div class="border">
                Content
              </div>
            </div>
          </div>
          <div class="bg-white p-5 rounded shadow">
            <h3 class="text-lg font-medium text-gray-700 mb-4 border-b-2">To Do</h3>
            <div class="py-1 flex flex-col">
              <div class="border mb-1 px-4 py-6">
                Content
              </div>
              <div class="border">
                Content
              </div>
            </div>
          </div>
          <div class="bg-white p-5 rounded shadow">
            <h3 class="text-lg font-medium text-gray-700 mb-4 border-b-2">To Do</h3>
            <div class="py-1 flex flex-col">
              <div class="border mb-1 px-4 py-6">
                Content
              </div>
              <div class="border">
                Content
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>
  </div>
</template>
