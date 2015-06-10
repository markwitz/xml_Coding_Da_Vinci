class DefaultController < ApplicationController
  def member
    members = {
      dennis: {
        name: "Dennis H",
        degree: "Master"
      },

      paul: {
        name: "Paul K",
        degree: "Master"
      },
      lucas: {
        name: "Lucas",
        degree: "Master"
      },
    }
    render xml: members
  end
end
