Rails.application.routes.draw do
  resources :answers
  resources :questions

  get '/quiz', to: 'quizzes#index'
  get '/member', to: 'default#member'
end
