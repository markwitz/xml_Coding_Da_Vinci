Rails.application.routes.draw do
  root to: 'quiz#index'
  get 'quiz/index'
  get '/quiz', to: 'quiz#index'
  get '/member', to: 'default#member'
end
