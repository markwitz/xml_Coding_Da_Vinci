class CreateAnswers < ActiveRecord::Migration
  def change
    create_table :answers do |t|
      t.string :title
      t.timestamps null: false
    end

    create_table :questions_answers do |t|
      t.belongs_to :answer, index: true
      t.belongs_to :question, index: true
    end
  end
end
