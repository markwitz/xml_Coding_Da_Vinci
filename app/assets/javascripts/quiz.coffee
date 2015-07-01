handleAnswerClick = ->
  counter = 0
  if $(this).hasClass('hoverable') && $(this).data('right') == true
    counter++
  parent = $(this).parent()
  for answer in parent.find('.answer')
    $(answer).removeClass('hoverable')
    if $(answer).data('right') == true
      $(answer).addClass('btn-success')
    else
      $(answer).addClass('btn-danger')
  parent.find('.author-info-button').show()
  parent.find('.next-slide').show()

fadeOutCurrentQuestionBox = ->
  console.log 'click on next'
  console.log $(this)
  console.log $(this).closest('.question-box')
  $(this).closest('.question-box').fadeOut()

$ ->
  $('.counter')
  $('.author-info-button').hide()
  $('.next-slide').hide()
  windowHeight = $(window).height()
  $('.container').css('width': '900')
  $('.question-box').css('height': windowHeight)
  $('.hoverable').on 'click', handleAnswerClick
  $('.next-slide').on 'click', fadeOutCurrentQuestionBox
